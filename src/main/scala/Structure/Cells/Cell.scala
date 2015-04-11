package Structure.Cells

/**
 * Created by zach on 4/5/15.
 */

abstract class Cell {

  val min: Byte

  val max: Byte

  def next: Cell

  def prev: Cell

  def minimize: Cell

  def maximize: Cell

}

class Binary(state: Byte) extends Cell {

  override val min: Byte = 0

  override val max: Byte = 1

  override def prev: Cell = new Binary(0)

  override def next: Cell = new Binary(1)

  override def minimize: Cell = next

  override def maximize: Cell = prev

}

class Tertiary(state: Byte) extends Cell {

  override val min: Byte = _

  override val max: Byte = _

  override def prev: Cell = if (state > min) new Tertiary( (state - 1 ).toByte ) else this

  override def next: Cell = if (state < max) new Tertiary( (state + 1 ).toByte ) else this

  override def minimize: Cell = new Tertiary(min)

  override def maximize: Cell = new Tertiary(max)

}




