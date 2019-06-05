package tech.burdzi0.ineedtofinishthisasap.view

import tech.burdzi0.ineedtofinishthisasap.model.Link

interface LinkViewTransformer {
    fun transform(link: Link?): String
}
