package Structure.Cellery

import Structure.Cells._

trait CellArray[U <: Cell[U]] { self =>

  /**
   * Type aliases for legibility
   */
  type C = Cell[U]

  type CArray = CellArray[U]

  /**
   * the number of dimensions of this CellArray. Requires that dim is
   * at least 1.
   */
  val dim: Int

  val cells: Map[List[Int], C]

  /**
   *
   * @param pos
   * @return
   */
  def cellAt(pos: Int*): C = {
    cellAt(pos.toList)
  }

  /**
   *
   * @param pos
   * @return
   */
  def cellAt(pos: List[Int]): C = {
    require(pos.length == dim)
    cells(pos.toList)
  }

  /**
   *
   * @param updatedCell
   * @param pos
   * @return
   */
  private def updatedCellArray(updatedCell: C, pos: List[Int]): CArray = {
    new CArray {
      override val cells: Map[List[Int], C] = self.cells.updated(pos, updatedCell)
      override val dim: Int = self.dim
    }
  }

  /**
   *
   * @param f
   * @return
   */
  def subSet(f: List[Int] => List[Int] => Int)(r: Int, center: Int*): CArray = {
    val d = f(center.toList)
    new CArray{
      override val dim = self.dim
      override val cells = self.cells filter ( x =>  d(x._1) <= r)
    }
  }

  /**
   * Increments the cell a position pos by one Byte
   * and returns a new CellArray with this new Cell
   * @param pos
   * @return the updated CellArray
   */
  def incrmCell(pos: Int*): CArray = {
    val updatedCell = cellAt(pos.toList).next
    updatedCellArray(updatedCell, pos.toList)
  }

  /**
   *
   * @param pos
   * @return
   */
  def decrmCell(pos: Int*): CArray = {
    val updatedCell = cellAt(pos.toList).prev
    updatedCellArray(updatedCell, pos.toList)
  }

  /**
   *
   * @return
   */
  override def toString: String =
    getClass.getName + " - " + "dim = " + dim + "\n" + "Cells:\n" +cells

}

/**
 * CellArray Factory object
 */
object CellArray {

  /**
   *
   * @param cellVec
   * @return
   */
  def apply[U <: Cell[U]](bounds: List[Int], cellVec: Vector[Cell[U]]): CellArray[U] = {
    require(bounds.length > 0 && bounds.product == cellVec.length )

    /**
     *
     * @param bounds
     * @param acc
     * @return
     */
    def collect(bounds: List[Int], acc: List[List[Int]]): List[List[Int]] = bounds match {
      case Nil => acc
      case b::bs =>
        val more: List[List[Int]] =
          for {
            a <- acc
            c <- 0 until b
          } yield c :: a
          collect(bs, more)
    }

    /**
     *
     */
    new CellArray[U] {
      override val dim = bounds.length
      override val cells: Map[List[Int], Cell[U]] = (collect(bounds, List(Nil)) zip cellVec).toMap
    }
  }
}
