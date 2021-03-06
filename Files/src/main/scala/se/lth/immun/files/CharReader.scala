package se.lth.immun.files

import java.io.Reader

object CharReader {
	val BEFORE_READ = -2
	val EOF = -1
}

class CharReader(reader:Reader) {
	
	var char:Int = CharReader.BEFORE_READ
	var lineNo:Int = 0
	var colNo:Int = 0
	
	def next = char = reader.read()
	
	def until(c:Char):String = {
		var sb:StringBuilder = new StringBuilder()
		
		if (char == CharReader.BEFORE_READ)
			char = reader.read()
		
		while (char != c) {
			if (char == CharReader.EOF) return sb.toString()
			val c = char.toChar
			if (c == '\n') {
				lineNo += 1
				colNo = 0
			} else
				colNo += 1
			
			sb += c
			next
		}
		
		return sb.toString()
	}

	def lineTag = "[line "+lineNo+"]"
}
