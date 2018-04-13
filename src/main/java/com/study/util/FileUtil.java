package com.study.util;

import java.text.DecimalFormat;

public class FileUtil {
//정적메서드 호출 예시
	
	// 300 "300 bytes" , 1024 bytes => 1 Kb , 1024Kb => 1Mb ...
	public static String fancySize(double size) {
		DecimalFormat df = new DecimalFormat("###,###.0"); // DecimailFormat .0 소수점 1자리까지 나오게 하려고쓴거임.
		if (size < 1024) {
			return size + "Bytes";
		} else if (size < (1024 * 1024)) {
			/* 2048/1024 = 2. xx */
			return df.format(size / 1024) + "Kb";
		} else {
			return df.format(size / (1024 * 1024)) + "Mb";
		}
	}
	
	public static void main(String[] args) {
		System.out.println( 14 / 5.0);
		System.out.println(FileUtil.fancySize(500)); 
		System.out.println(FileUtil.fancySize(1025)); //2 kb 이상 
		System.out.println(FileUtil.fancySize(5050000)); //1 Mb 이상 
		
	}

}
