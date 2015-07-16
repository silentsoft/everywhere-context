package org.silentsoft.everywhere.context.model.pojo;

import java.io.InputStream;

public class FilePOJO {
	
	private String name;
	
	private String extension;
	
	private InputStream inputStream;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
