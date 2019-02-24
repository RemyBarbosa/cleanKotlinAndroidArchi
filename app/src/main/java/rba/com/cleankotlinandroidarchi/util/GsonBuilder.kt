package rba.com.cleankotlinandroidarchi.util

import com.google.gson.Gson
import org.joda.time.DateTime

object GsonBuilder {

    val gson: Gson
        get() = com.google.gson.GsonBuilder()
            .registerTypeAdapter(DateTime::class.java, DateTimeSerializer())
            .registerTypeAdapter(DateTime::class.java, DateTimeDeserializer())
            .create()

}