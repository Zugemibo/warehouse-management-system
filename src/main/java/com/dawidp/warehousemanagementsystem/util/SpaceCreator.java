package com.dawidp.warehousemanagementsystem.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SpaceCreator {

	public static List<String> createPaletteSpace(int alley, int rack, int height) {
		String code = null;
		
		List<String> spaceList = new ArrayList<String>();
		for (int a = 1; a < alley + 1; a++) {
			for (int r = 1; r < rack + 1; r++) {
				for (int h = 1; h < (height*3) + 1; h++) {
					code = (String.format("%03d", a) + "-" + String.format("%03d", r) + "-" + String.format("%03d", h));
					spaceList.add(code);
				}
			}
		}
		System.out.println(spaceList.size());
		return spaceList;
	}
}
