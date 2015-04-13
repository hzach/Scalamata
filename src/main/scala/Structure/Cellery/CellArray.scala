package Structure.Cellery

import Structure.Cells._

trait CellArray[U <: Cell[U]] {

  /**
   * the number of dimensions of this CellArray. Requires that dim is
   * at least 1.
   */
  val dim: Int

  val cells: Map[List[Int], Cell[U]]

  /**
   *
   * @param pos
   * @return
   */
  def cellAt(pos: List[Int]): Cell[U] = {
    require(pos.length == dim)
    cells(pos)
  }
  //def neighbors(pos: List[Int]): Cell
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
    require(bounds.length > 0)

    /**
     *
     * @param bounds
     * @param acc
     * @return
     */
    def collect(bounds: List[Int], acc: List[List[Int]]): List[List[Int]] = bounds match {
      case Nil => acc
      case b::bs => {
        val more: List[List[Int]] =
          for {
            a <- acc
            c <- 0 until b
          } yield c :: a
          collect(bs, more)
      }
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
