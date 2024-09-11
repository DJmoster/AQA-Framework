package sviat.dev.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
* 1. Serialization-Deserialization: <br>
* a) Make some complex models using your variant. <br>
* b) Make it serializable. <br>
* c) Read JSON from “input.json” <br>
* d) and deserialize it to POJO. <br>
* e) Then change a few fields and save it to “output.json”. <br>
* f) Do the same for XML. <br>
* <p><br>
* 2. Stream: <br>
* a) Generate 10 random objects using a class from a previous task <br>
* b) Sort it using any two fields using stream. <br>
* c) Filter it by any two fields custom filter. <br>
* d) Collect it to List with *main field(s). <br>
* <p>
* 3. Write a maven command for executing one of your tasks with arguments (number of elements).
*/
public class Task5 {
    public static void main(String[] args) {
        serializationAndDeserializationTask();

        streamTask(Integer.parseInt(args[0]));
    }

    public static void streamTask(int count) {
        List<Meeting> meetings = generateRandomMeetings(count);

        meetings = meetings.stream()
                .sorted((
                    Comparator.comparing(Meeting::getTitle)
                            .thenComparing(Meeting::getDescription)
                ))
                .filter(o ->
                    o.getTitle().startsWith("Meeting")
                    && o.getDescription().startsWith("Description")
                )
                .collect(Collectors.toList());

        System.out.println(meetings);
    }

    public static List<Meeting> generateRandomMeetings(int count) {
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            meetings.add(new Meeting("Meeting " + i, null, "Description " + i));
        }

        return meetings;
    }

    public static void serializationAndDeserializationTask() {
        ObjectMapper objectMapper = new ObjectMapper();

        Meeting meetingJson = readObjectFromFile("src/main/resources/input.json", objectMapper);
        System.out.println(meetingJson);

        meetingJson.setTitle("Changed Meeting Title JSON");
        saveObjectToFile("src/main/resources/output.json", meetingJson, objectMapper);

        XmlMapper xmlMapper = new XmlMapper();

        Meeting meetingXml = readObjectFromFile("src/main/resources/input.xml", xmlMapper);
        System.out.println(meetingXml);

        meetingXml.setTitle("Changed Meeting Title XML");
        saveObjectToFile("src/main/resources/output.xml", meetingXml, xmlMapper);
    }

    public static Meeting readObjectFromFile(String fileName, ObjectMapper mapper) {
        try {
            return mapper.readValue(new File(fileName), Meeting.class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveObjectToFile(String fileName, Meeting meeting, ObjectMapper mapper) {
        try {
            mapper.writeValue(new File(fileName), meeting);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
