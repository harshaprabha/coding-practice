package javaBasics.generics.taxables;

import java.util.ArrayList;
import java.util.List;

public class TaxPreparer {

  public static void prepareTaxes(Taxable t) {

  }

  /**
   * Covariant param
   * ? => caller type assigning CallerType(Individual) to List<?> => List<Individual>
   *   With covariance we can read items from a structure, but we cannot write anything into it
   *
   */
  public static void prepareBulkTaxes(
      List<? extends Taxable> lt) { // accept certain and reject the other

    // lt.add(new Corporation()); //LSP violation with ? extends but compiler will allow this after type erasure
    //  lt.add(new Individual()); //compiler error as its not universally safe. even if tehre is one failing case, compiler will throw an error

    for (Taxable taxable : lt) // we have assigned ? type to Taxable
    {
      prepareTaxes(taxable);
    }

  }


  // Contravariant param
  // With contravariance we can do the opposite. We can put things into a generic structure, but we cannot read anything out of it.
  static void getIndividualClients(List<? super Individual> individualList) {
    individualList.add(new Individual());
    individualList.add(new Individual());
  }

  public static void main(String[] args) {

    List<Taxable> list = new ArrayList<>();
    list.add(new Corporation());
    list.add(new Corporation());
    list.add(new Individual());

    prepareBulkTaxes(list);

    /**
     *
     * Liskov's Substitution principle violation
     *
     * List<Individual> individualList = new ArrayList<>();
     *     individualList.add(new Individual());
     *     individualList.add(new Individual());
     *
     *     prepareBulkTaxes(individualList);
     *
     */

    getIndividualClients(list); // Any class >=Individual can be assigned

    List<Individual> individualList = new ArrayList<>();
    individualList.add(new Individual());
    individualList.add(new Individual());

    List<IndividualChild> children= new ArrayList<>();
    children.add(new IndividualChild());

    prepareBulkTaxes(individualList); // possible LSP violation
    // getIndividualClients(children); // not possible as any class below Individual cannot be assigned


  }
}
