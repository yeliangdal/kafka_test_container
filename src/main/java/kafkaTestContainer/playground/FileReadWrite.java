package kafkaTestContainer.playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadWrite {
    public static void main(String... args) throws IOException {
        Path path = Path.of("/Users/ye/Documents/projects/kafka_test_container/src/main/java/kafkaTestContainer/playground/FooBar.java");
//        List<String> content = Files.readAllLines(path);
//        content.forEach(System.out::println);
//        System.out.println(content);
        StringBuilder sb = new StringBuilder();
        try (Stream<String> lines = Files.lines(path)) {
            sb.append(lines.collect(Collectors.joining()));
        }
        System.out.println(sb.toString());
    }
}
