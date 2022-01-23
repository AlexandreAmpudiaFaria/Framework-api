package br.com.framework.api.frameworkapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.framework.api.frameworkapi.model.Link;

public class LinkDto {

	private Long id;
	private String url;

	public LinkDto() {

	}

	public LinkDto(Link link) {
		this.id = link.getId();
		this.url = link.getUrl();
	}

	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public static List<LinkDto> convert(List<Link> links) {
		return links.stream().map(LinkDto::new).collect(Collectors.toList());
	}

}
