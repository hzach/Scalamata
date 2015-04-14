package Structure.Cells

/**
 * TODO: Doc.
 */
trait Cell[U <: Cell[U]] { self =>

  /**
   *
   */
  val state: Byte

  /**
   *
   */
  val min: Byte = 0

  /**
   *
   */
  val max: Byte

  /**
   *
   * @return
   */
  def next: Cell[U] =
    if (self.state < max)
      new Cell[U] {
        override val max: Byte = self.max
        override val state: Byte = (self.state + 1).toByte
      }
    else
      this

  /**
   *
   * @return
   */
  def prev: Cell[U] =
    if (self.state > min)
      new Cell[U] {
        override val max: Byte = self.max
        override val state: Byte = (self.state - 1).toByte
      }
    else
      this

  /**
   *
   * @return
   */
  def minimize: Cell[U] =
    new Cell[U] {
      override val state: Byte = self.min
      override val max: Byte = self.max
    }

  /**
   *
   * @return
   */
  def maximize: Cell[U] =
    new Cell[U] {
      override val state: Byte = self.max
      override val max: Byte = self.max
    }

  override def toString: String = state.toString

}

/**
 * TODO: Doc
 * @param state
 */
case class Binary(state: Byte) extends Cell[Binary] { override val max: Byte = 1 }

/**
 * TODO: Doc
 * @param state
 */
case class Tertiary(state: Byte) extends Cell[Tertiary] { override val max: Byte = 2 }

/**
 * TODO: Doc
 * @param state
 * @param max
 */
case class nAry(state: Byte, max: Byte = Byte.MaxValue) extends Cell[nAry]




