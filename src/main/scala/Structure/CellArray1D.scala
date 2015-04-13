package Structure

/**
 * Created by zach on 4/5/15.
 */
class CellArray1D(val cells: Vector[Cell], val dim: Int = 1) extends CellArray {

  /**
   * Get the cell at the specified coordinates
   * @param pos
   * @return
   */
  override def getCell(pos: Int*): Cell = cells(pos.head)


  /**
   * Get the Cell to the right of the cell at position pos
   * @param pos
   */
  def leftOf(pos: Int): Cell = cells(pos + 1)

  /**
   * Get the Cell to the right of the cell at position pos
   * @param pos
   * @return
   */
  def rightOf(pos: Int): Cell = cells(pos + 1)

  /**
   *
   * @param pos
   * @return
   */
  def neighbors(pos: Int): (Cell, Cell) = (leftOf(pos), rightOf(pos))
}
