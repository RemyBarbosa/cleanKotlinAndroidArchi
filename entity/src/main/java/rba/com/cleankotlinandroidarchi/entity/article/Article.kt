package rba.com.cleankotlinandroidarchi.entity.article

import org.joda.time.DateTime

data class Article(
    val title: String,
    val url: String,
    val creationDate: DateTime
) {
    companion object {
        private const val NB_DAY_TO_WAIT_BEFORE_PUBLICATION = 1
    }

    fun isReleasable(): Boolean = creationDate.isBefore(DateTime.now().minusDays(NB_DAY_TO_WAIT_BEFORE_PUBLICATION))
}