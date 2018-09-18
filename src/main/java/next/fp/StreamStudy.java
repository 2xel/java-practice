package next.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

	public static long countWords() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		return words.stream().filter(word -> word.length() > 12).count();
	}
	
	public static void printLongestWordTop100() throws IOException {
		String contents = new String(Files.readAllBytes(Paths
				.get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		
		words
			.stream()
			.filter(word -> word.length() > 12)	// 길이가 12자를 초과하는 단어
			.distinct()							// 중복제거
			.sorted((value1, value2) -> value1.length() - value2.length())	// 긴 순서로 정렬
			.limit(100)							// 100개의 단어 추출
			.map(word -> word.toLowerCase())	// 소문자로 변경
			.forEach(System.out::println);	
	}

	public static List<Integer> doubleNumbers(List<Integer> numbers) {
		return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
	}

	public static long sumAll(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x, y) -> x + y);
	}

	public static long sumOverThreeAndDouble(List<Integer> numbers) {
		return numbers.stream().filter(number -> number > 3).map(number -> number * 2).reduce(0, (value1, value2) -> value1 + value2);
	}
}