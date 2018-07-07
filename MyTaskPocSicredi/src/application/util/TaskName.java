package application.util;

import java.util.Random;

public class TaskName {
	private static String taskName;
	private static String subTaskName;
	
	public static void newTaskName(){
		taskName 	= "";
		subTaskName = "";
	}
	
	public static String getUniqueTaskName(){
		return taskName;
	}
	
	public static void setTaskName(){
		String taskPrefix = "[AUTO_TASK_APP] - Test_";
		taskName = taskPrefix+randomNum();
	}
	
	public static String getUniqueSubTaskName(){
		return subTaskName;
	}
	
	public static void setSubTaskName(){
		String subTaskPrefix = "[AUTO_SUBTASK_APP] - Test_";
		subTaskName = subTaskPrefix+randomNum();
	}
	
	
	public  static int randomNum() {
		Random rand = new Random();
		return rand.nextInt(500) + 1;
	}
}
