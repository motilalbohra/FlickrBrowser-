package com.bohraexample.flickrbrower

import android.icu.text.CaseMap
import android.util.Log
import java.io.IOException
import java.io.ObjectOutputStream
import java.io.ObjectStreamException
import java.io.Serializable

class Photo(var title: String,var author:String,var authorId:String,var link:String,var tags:String,
            var Image:String): Serializable {

    companion object{
        private const val serialVersion=1L
    }
    override fun toString(): String {
        return "Photo(title='$title', author='$author', authorId='$authorId', link='$link', tags='$tags', Image='$Image')"
    }

    @Throws(IOException::class)
    private fun writeObject(out:java.io.ObjectOutputStream){
        Log.d("Photo","writeObject called")
        out.writeUTF(title)
        out.writeUTF(author)
        out.writeUTF(authorId)
        out.writeUTF(link)
        out.writeUTF(tags)
        out.writeUTF(Image)
    }
    @Throws(IOException::class,ClassNotFoundException::class)
    private fun readObject(inStream:java.io.ObjectInputStream){
        Log.d("Photo","readObject called")
        title=inStream.readUTF()
        author=inStream.readUTF()
        authorId=inStream.readUTF()
        link=inStream.readUTF()
        tags=inStream.readUTF()
        Image=inStream.readUTF()

    }
    @Throws(ObjectStreamException::class)
    private fun readObjectNotData(){
        Log.d("Photo","readObjectNotData called")

    }

}