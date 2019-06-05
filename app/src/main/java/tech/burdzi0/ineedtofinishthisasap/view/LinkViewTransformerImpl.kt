package tech.burdzi0.ineedtofinishthisasap.view

import tech.burdzi0.ineedtofinishthisasap.model.Link
import java.lang.StringBuilder

class LinkViewTransformerImpl: LinkViewTransformer {

    override fun transform(link:Link?): String {
        if (link == null) {
            return "No link found!"
        }
        return transformLink(link)
    }

    private fun transformLink(link: Link): String {
        val strBuilder = StringBuilder()
        strBuilder.append("- Link - ")
        strBuilder.append(System.lineSeparator())
        strBuilder.append("URL: ")
        strBuilder.append(link.url)
        strBuilder.append(System.lineSeparator())
        strBuilder.append("Since: ")
        strBuilder.append(link.since)
        strBuilder.append(System.lineSeparator())
        strBuilder.append("Expiration: ")
        strBuilder.append(link.expiration)
        return strBuilder.toString()
    }
}