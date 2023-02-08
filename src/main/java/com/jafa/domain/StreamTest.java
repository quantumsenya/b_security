package com.jafa.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class StreamTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("kim");
		list.add("park");
		list.add("na");
		
		list.stream().forEach(p->System.out.println(p) );
		List<MemberName> collect = list.stream().map(n->new MemberName(n))
				.collect(Collectors.toList());
		System.out.println(collect);
	}
}

@AllArgsConstructor
@ToString
class MemberName{
	String name;
}