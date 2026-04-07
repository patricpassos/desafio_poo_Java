package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class ProgramLearningPlatform {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Lesson> listLesson = new ArrayList<>();

		System.out.print("How many classes are in the course? ");
		int numberCourse = sc.nextInt();

		for (int i = 0; i < numberCourse; i++) {
			System.out.printf("\nData from the %d° lesson: \n", i + 1);
			System.out.print("Content or task (c/t)? ");
			char contentOrTask = sc.next().toLowerCase().charAt(0);

			while (contentOrTask != 'c' && contentOrTask != 't') {
				System.out.print("Please choose: Content or task (c/t)? ");
				contentOrTask = sc.next().toLowerCase().charAt(0);
			}

			System.out.print("Title: ");
			sc.nextLine();
			String title = sc.nextLine();

			if (contentOrTask == 'c') {
				System.out.print("Video URL: ");
				String urlVideo = sc.next();
				System.out.print("Duration in seconds: ");
				int duration = sc.nextInt();
				Lesson video = new Video(title, urlVideo, duration);
				listLesson.add(video);
			} else if (contentOrTask == 't') {
				System.out.print("Description: ");
				String description = sc.nextLine();
				System.out.print("Number of questions: ");
				int numberQuestion = sc.nextInt();
				Lesson task = new Task(title, description, numberQuestion);
				listLesson.add(task);
			}
		}

		int durationCourse = 0;
		for (Lesson duration : listLesson) {
			durationCourse += duration.duration();
		}
		
		System.out.printf("\nTOTAL COURSE DURATION = %d seconds", durationCourse);

		sc.close();

	}

}
