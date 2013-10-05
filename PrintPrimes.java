//A" - Dominic Daniel Kent - 260491325

public class PrintPrimes {
  int numberOfPrimes;
  int rowsPerPage;
  int columnsPerPage;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int rowsPerPage, int columnsPerPage) {
    this.numberOfPrimes   = numberOfPrimes;
    this.rowsPerPage  = rowsPerPage;
    this.columnsPerPage  =columnsPerPage;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 10, 30);
      printPrimes.calculatePrimes();
      printPrimes.print();
  }

  public void calculatePrimes() {
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean isPRIME;
      int N;
      int MULT[] = new int[ORDMAX + 1];

      int J = 1;
      int ORD = 2;
      int SQUARE = 9;

      for(int primesFoundSoFar = 1; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          J = J + 2;
          if (J == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            MULT[ORD - 1] = J;
          }
          N = 2;
          JPRIME = true;
          while (N < ORD && isPRIME) {
            while (MULT[N] < J)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
            if (MULT[N] == J)
              isPRIME = false;
            N = N + 1;
          }
        } while (!isPRIME);
        listOfPrimes[primesFoundSoFar] = J;
      }
    }

    public void print() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + rowsPerPage; ROWOFFSET++){
            for (int column = 0; column < columnsPerPage ; column++)
              if (ROWOFFSET + column * rowsPerPage <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + column * rowsPerPage]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + rowsPerPage * columnsPerPage;
        }
    }
}

					 
