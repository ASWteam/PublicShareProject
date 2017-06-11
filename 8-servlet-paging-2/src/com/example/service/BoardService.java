package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.example.dto.Board;

// 디비 흉내를 내는 가짜 객체(Mock Object)
public class BoardService {
	private List<Board> boards = new ArrayList<Board>();
	
	{
		for (int i = 1; i <= 21; i++) {
			boards.add(new Board(i, "title"+i, "writer"+i, 
					new Date(), i*10, "content"+i));
		}
	}
	
	public List<Board> select(){
		return boards;
	}
	
	public Board selectByKey(final int bno){
		return boards.stream().filter(new Predicate<Board>() {
			@Override
			public boolean test(Board t) {
				return t.getBno() == bno;
			}
		}).findAny().orElse(null);
	}

	public int count() {
		return boards.size();
	}

	public List<Board> selectByLimit(int currentPage, int rowsPerPage) {
		int end = rowsPerPage*currentPage;
		int start = end-rowsPerPage+1;
		System.out.println(start+","+end);
		
		List<Board> articles = new ArrayList<>();
		for (int i = start-1; i <= (end-1) && i < boards.size(); i++) {
			articles.add(boards.get(i));
		}
		return articles;
	}
}
