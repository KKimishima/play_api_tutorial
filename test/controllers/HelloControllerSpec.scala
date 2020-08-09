package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._

class HelloControllerSpec extends PlaySpec with GuiceOneAppPerTest {
  "HelloControllerSpec GET" must {
    "/hello get　にアクセスできる" in {
      val req = FakeRequest(GET, "/hello")
      val res = route(app, req).get
      status(res) mustBe OK
      contentType(res) mustBe Some("text/plain")
      contentAsString(res) mustBe "Hello world"
    }
  }
}
