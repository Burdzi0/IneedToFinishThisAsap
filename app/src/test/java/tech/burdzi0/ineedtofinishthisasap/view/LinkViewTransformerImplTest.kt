package tech.burdzi0.ineedtofinishthisasap.view

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import tech.burdzi0.ineedtofinishthisasap.model.Link

@RunWith(MockitoJUnitRunner::class)
class LinkViewTransformerImplTest {

    private var link: Link? = Link(1,"www.google.pl", "","2019-07-08T12:41:30.399331")

    @Test
    fun transformShouldTransformLink() {
        val linkViewTransformer = LinkViewTransformerImpl()
        val res = linkViewTransformer.transform(link)
        Assert.assertEquals("- Link - \n" +
                "ID: 1\n" +
                "URL: www.google.pl\n" +
                "Since: \n" +
                "Expiration: 2019-07-08T12:41:30.399331", res)
    }

    @Test
    fun transformShouldReturnNotFound() {
        val linkViewTransformer = LinkViewTransformerImpl()
        val res = linkViewTransformer.transform(null)
        Assert.assertEquals("No link found!", res)
    }
}