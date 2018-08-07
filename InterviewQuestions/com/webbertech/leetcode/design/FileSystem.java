package com.webbertech.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/*
 * Design in- memory file system.
 * 
 *  A basic system will consists of files and directories.
 *  From cracking coding interviews, this should be ok.  
 *  
 *   * */

abstract class Entry {
	Directory parent;
	long created;
	long lastUpdated;
	long lastAccessed;
	String name;
	String owner;
	Permission perm;
	abstract int size();
}

class Directory extends Entry {

	// a list of files or directories
	List<Entry> contents;

	Directory() {
		contents = new ArrayList<>();
	}

	// count all the files in the subdirectories
	public int numberOfFiles() {
		int count = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				count += ((Directory) e).numberOfFiles();
			}
			// is File
			count++;
		}
		return count;
	}

	List<Entry> getContents() {
		return contents;
	}

	// size is the counts of all the files including subdirectories and files
	int size() {
		int size = 0;
		for (Entry e : contents) {
			size += e.size();
		}
		return size;
	}

	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}

	public void addEntry(Entry entry) {
		contents.add(entry);
	}
}

class Permission {}

class File extends Entry {
	String contents;
	int size;
	String owner;

	void setContents(String s) {
		contents = s;
	}

	String getContents() {
		return contents;
	}

	int size() {
		// TODO Auto-generated method stub
		return size;
	}
}

public class FileSystem {

}
