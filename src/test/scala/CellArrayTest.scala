

import Structure.Cellery.CellArray
import Structure.Cells.{Tertiary, Binary, nAry}
import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CellArrayTest extends FunSuite {

  trait TestCA{

    val vect8 =
      Vector(Binary(0), Binary(0), Binary(1),
             Binary(0), Binary(1), Binary(0),
             Binary(1), Binary(0))

    val vect9 =
      Vector(Binary(0), Binary(0), Binary(1),
             Binary(0), Binary(1), Binary(0),
             Binary(1), Binary(0), Binary(0))

    val vect9T =
      Vector(Tertiary(2), Tertiary(0), Tertiary(1),
             Tertiary(0), Tertiary(1), Tertiary(0),
             Tertiary(1), Tertiary(0), Tertiary(2))

    val ca1D = CellArray( List(2), Vector(Binary(0), Binary(1)))

    val ca2D = CellArray( List(3,3), vect9 )

    val ca3D = CellArray( List(2, 2, 2), vect8 )

    val ca2DT = CellArray( List(3, 3), vect9T )
  }

  test("CellArray indices") {
    new TestCA {
      assert(  ca1D.cellAt(1).state === 1)
      assert(ca2D.cellAt(1,1).state === 1)
      assert(ca2D.cellAt(1,2).state === 0)
    }
  }

  test("CellArray Update") {
    new TestCA {

      val updated0_ca2D = ca2D.incrmCell(0,0)
      val updated1_ca2D = updated0_ca2D.incrmCell(0,0)
      assert(updated0_ca2D.cellAt(0,0).state === 1)
      assert(updated1_ca2D.cellAt(0,0).state === 1)

      val updt0_ca2DT = ca2DT.incrmCell(1,1)
      val updt1_ca2DT = updt0_ca2DT.decrmCell(0,1)
      assert(updt0_ca2DT.cellAt(1, 1).state === 2)
      assert(updt1_ca2DT.cellAt(0, 1).state === 0)

    }
  }
}
