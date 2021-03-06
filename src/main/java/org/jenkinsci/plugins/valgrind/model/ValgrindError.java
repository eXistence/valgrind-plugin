package org.jenkinsci.plugins.valgrind.model;

import java.io.File;
import java.io.Serializable;

import org.jenkinsci.plugins.valgrind.util.ValgrindUtil;


public class ValgrindError implements Serializable
{
	private static final long serialVersionUID = 6470943829358084900L;
	
	private String executable;
	private String uniqueId;	
	private ValgrindErrorKind kind;
	private ValgrindStacktrace stacktrace;
	private String description;
	private Integer leakedBytes;
	private Integer leakedBlocks;
	
	public String toString()
	{
		return 
		"kind: " + kind + "\n" +
		"text: " + description + "\n" +
		"stack: " + stacktrace.toString();
	}	
	
	public ValgrindStacktrace getStacktrace()
	{
		return stacktrace;
	}
	
	public void setStacktrace(ValgrindStacktrace stacktrace)
	{
		this.stacktrace = stacktrace;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = ValgrindUtil.trimToNull( description );		
	}
	
	public ValgrindErrorKind getKind()
	{
		return kind;
	}
	
	public void setKind(ValgrindErrorKind kind)
	{
		this.kind = kind;
	}

	public String getUniqueId()
	{
		return uniqueId;
	}

	public void setUniqueId(String uniqueId)
	{
		this.uniqueId = ValgrindUtil.trimToNull( uniqueId );
	}

	public String getExecutable()
	{
		return executable;
	}

	public void setExecutable(String executable)
	{
		this.executable = ValgrindUtil.trimToNull( executable );
		
		if ( this.executable != null )
			this.executable = new File(this.executable).getName();
	}
	
	public Integer getLeakedBytes() {
		return leakedBytes;
	}

	public void setLeakedBytes(Integer leakedBytes) {
		this.leakedBytes = leakedBytes;
	}

	public Integer getLeakedBlocks() {
		return leakedBlocks;
	}

	public void setLeakedBlocks(Integer leakedBlocks) {
		this.leakedBlocks = leakedBlocks;
	}	
}
