import Structure.Cells.{Tertiary, Binary, nAry}
import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CellTest extends FunSuite {

  trait TestCells{
    val bCell1 = Binary(0)
    val tCell1 = Tertiary(0)
    val nCell1 = nAry(0)
  }

  test("Binary cell prev, next, max, min"){
    new TestCells {
      val nextBcell = bCell1.next
      assert(nextBcell.state == 1)
      println("max val: " + nextBcell.max)
      println("min val: " + nextBcell.min)
    }
  }

}
