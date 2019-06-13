package tech.burdzi0.ineedtofinishthisasap.model.api

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import tech.burdzi0.ineedtofinishthisasap.model.Link

@RunWith(MockitoJUnitRunner::class)
class LinkServiceImplTest {

    @Mock
    private lateinit var linkService: LinkService

    private val link1 = Link(1, "www.google.pl", "2017-06-05T23:33:34+0000", "2019-06-05T23:33:34+0000")
    private val link2 = Link(2, "www.wp.pl", "2017-06-05T23:33:34+0000", "2019-06-05T23:33:34+0000")

    @Before
    fun prepareLinkService() {
        `when`(linkService.getLinkById(1))
            .thenReturn(link1)
        `when`(linkService.getLinkById(2))
            .thenReturn(link2)
        `when`(linkService.getLinkById(3))
            .thenReturn(null)
        `when`(linkService.getAllLinks()).thenReturn(listOf(link1, link2))
    }

    @Test
    fun getLinkByIdShouldReturn1Link() {
        assertEquals(linkService.getLinkById(1), link1)
    }

    @Test
    fun getLinkByIdShouldReturn2Link() {
        assertEquals(linkService.getLinkById(2), link2)
    }

    @Test
    fun getLinkByIdShouldNull() {
        assertEquals(linkService.getLinkById(3), null)
    }

    @Test
    fun getAllLinks() {
        val result  = linkService.getAllLinks()
        assertNotNull(result)
        assertEquals(2, result.size)
        assertEquals(link1, result[0])
        assertEquals(link2, result[1])
    }
}