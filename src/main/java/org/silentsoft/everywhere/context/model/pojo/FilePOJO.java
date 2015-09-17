package org.silentsoft.everywhere.context.model.pojo;

import java.io.InputStream;

public class FilePOJO {
	
	private String path;
	
	private boolean isDirectory;
	
	private String name;
	
	private String extension;
	
	private String size;
	
	private String userUniqueSeq;
	
	private InputStream inputStream;
	
	private byte[] bytes;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

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
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getUserUniqueSeq() {
		return userUniqueSeq;
	}
	
	public void setUserUniqueSeq(String userUniqueSeq) {
		this.userUniqueSeq = userUniqueSeq;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
