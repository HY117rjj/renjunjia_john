package com.ycyl.edu.util;

import java.util.List;

import lombok.Data;

@Data
public class Dictionary {

	private String code;
	private String name;
	private String comment;
	
	private List<Dictionary> dataList;
	
}
