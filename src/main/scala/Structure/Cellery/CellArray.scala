package Structure.Cellery

import Structure.Cells.Cell

trait CellArray {
  
  //type CellArray = Either[List[CellArray], List[Cell]]
  /**
   * the number of dimensions of this CellArray. Requires that dim is
   * at least 1.
   */
  val dim: Int

  //Need to implement topology
  //val topology: Topology

  val cells: Either[List[CellArray], List[Cell]]

  /**
   *
   * @param pos
   * @return
   */
  def getCell(pos: List[Int]): Cell = {
    require(pos.length == dim)

    def collect(pos: List[Int], c: CellArray): Cell = c.cells match {
      case Right(r) => r(pos.head)
      case Left(l) => collect(pos.tail, l(pos.head))
    }

    collect(pos, this)
  }

  def neighbors(coord: Vector[Int]): Cell

}

/**
 * CellArray Factory object
 */
object CellArray {

  abstract class CellArray1D extends CellArray {
    override val dim: Int = 1
  }

  abstract class CellArray2D extends CellArray {
    override val dim: Int = 2
  }

  abstract class CellArray3D extends CellArray {
    override val dim: Int = 3
  }

  /**
   *
   * @param cells
   * @return
   */
  def apply(cells: Cell*): CellArray = ???

}
