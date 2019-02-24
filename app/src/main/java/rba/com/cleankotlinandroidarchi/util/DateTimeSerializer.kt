package rba.com.cleankotlinandroidarchi.util

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.lang.reflect.Type


class DateTimeSerializer : JsonSerializer<DateTime> {
    companion object {
        private const val DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ"
    }

    override fun serialize(
        datetime: DateTime,
        type: Type,
        jsonSerializationContext: JsonSerializationContext
    ): JsonElement {
        run {
            val formatter = DateTimeFormat.forPattern(DATE_TIME_PATTERN)
                .withZoneUTC()
            return JsonPrimitive(formatter.print(datetime))
        }
    }
} 