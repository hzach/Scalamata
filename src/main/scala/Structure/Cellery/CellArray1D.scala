package Structure.Cellery

import Structure.Cells.Cell

/**
 * Created by zach on 4/5/15.
 */
class CellArray1D(val cells: Vector[Cell]) extends CellArray{
  /**
   * Get the cell at the specified coordinates
   * @param coord
   * @return
   */
  override def getCell(coord: Int*): Cell = ???
}
