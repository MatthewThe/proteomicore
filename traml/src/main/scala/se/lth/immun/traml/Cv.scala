package se.lth.immun.traml

import se.lth.immun.xml.XmlReader
import se.lth.immun.xml.XmlWriter

object Cv {
	
	import TraML._
	
	def fromFile(r:XmlReader) = {
		var cv = new Cv
		
		cv.uri = r.readAttribute(URI)
		cv.fullName = r.readAttribute(FULL_NAME)
		cv.id = r.readAttribute(ID)
		cv.version = r.readAttribute(VERSION)
		
		r.next
		cv
	}
}

class Cv {
	
	var uri:String = null
	var fullName:String = null
	var id:String = null
	var version:String = null
	
	
	def write(w:XmlWriter) = {
		import TraML._
		
		w.startElement(CV)
		w.writeAttribute(ID, id)
		w.writeAttribute(FULL_NAME, fullName)
		w.writeAttribute(VERSION, version)
		w.writeAttribute(URI, uri)
		w.endElement
	}
}