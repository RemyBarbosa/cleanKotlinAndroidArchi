package rba.com.cleankotlinandroidarchi.util

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.lang.reflect.Type

class DateTimeDeserializer : JsonDeserializer<DateTime> {

    companion object {
        private const val DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ"
    }

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): DateTime {

        val formatter = DateTimeFormat.forPattern(DATE_TIME_PATTERN)
            .withZoneUTC()
        return formatter.parseDateTime(json.asString)
    }
} 