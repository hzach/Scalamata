

import Structure.Cellery.CellArray
import Structure.Cells.{Tertiary, Binary, nAry}
import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CellArrayTest extends FunSuite {

  test("CellArray 1D indices") {
    val _1D = CellArray( List(2), Vector(Binary(0), Binary(1)))
    val _2D = CellArray( List(2,2), Vector(Binary(0),Binary(1), Binary(1), Binary(0)))
    println(_2D.cells)
  }

}
