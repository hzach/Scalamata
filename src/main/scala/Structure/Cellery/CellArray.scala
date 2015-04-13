package Structure.Cellery

import Structure.Cells.Cell

trait CellArray[U<:Cell] {

  /**
   * the number of dimensions of this CellArray. Requires that dim is
   * at least 1.
   */
  val dim: Int

  val cells: Map[List[Int],Cell]

  /**
   *
   * @param pos
   * @return
   */
  def cellAt(pos: List[Int]): Cell = {
    require(pos.length == dim)
    cells(pos)
  }

  //def neighbors(pos: List[Int]): Cell

}

/**
 * CellArray Factory object
 */
object CellArray {

  abstract class CellArray1D extends CellArray[CellArray1D] {
    override val dim: Int = 1
  }

  abstract class CellArray2D extends CellArray[CellArray2D] {
    override val dim: Int = 2
  }

  abstract class CellArray3D extends CellArray[CellArray3D] {
    override val dim: Int = 3
  }

  /**
   *
   * @param cellVec
   * @return
   */
  def apply(dim: Int, bounds: List[Int], cellVec: Vector[Cell]): CellArray = {
    require(bounds.length == dim && dim > 0)

    dim match {
      case 1 =>
        new CellArray1D {
          override val cells: Map[List[Int], Cell] = ???
        }

      case 2 =>
        new CellArray2D {
          override val cells: Map[List[Int], Cell] = ???
        }

      case 3 =>
        new CellArray3D {
          override val cells: Map[List[Int], Cell] = ???
        }
    }
  }

}
