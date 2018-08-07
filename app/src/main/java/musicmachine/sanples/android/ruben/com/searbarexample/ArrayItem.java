package musicmachine.sanples.android.ruben.com.searbarexample;

import java.util.ArrayList;

import musicmachine.sanples.android.ruben.com.searbarexample.model.Actor;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Category;

public class ArrayItem {

   public static final String[] arrays = new String[]{"98411","98422","98433","98444","98455","98466","98477","98488","98499","98400" };

   public static final ArrayList<Category> getData() {
      ArrayList<Actor> drama = new ArrayList<>();
      drama.add(new Actor("Tom Hardy",  "(541) 754-3010", "https://api.androidhive.info/json/images/tom_hardy.jpg"));
      drama.add(new Actor("Johnny Depp", "(452) 839-1210", "htps://api.androidhive.info/json/images/johnny.jpg"));
      drama.add(new Actor("Keira Knightley", "(535) 324-4334", "https://api.androidhive.info/json/images/keira.jpg"));
      drama.add(new Actor("Leonardo DiCaprio", "(564) 333-2452", "https://api.androidhive.info/json/images/leonardo.jpg"));
      drama.add(new Actor("Brad Pitt", "(567) 754-8945", "https://api.androidhive.info/json/images/brad.jpg"));
      drama.add(new Actor("Angelina Jolie", "(324) 754-5433", "https://api.androidhive.info/json/images/angelina.jpg"));
      drama.add(new Actor("Kate Winslet", "(788) 343-3433", "https://api.androidhive.info/json/images/kate.jpg"));
      drama.add(new Actor("Christian Bale", "(865) 755-3555", "https://api.androidhive.info/json/images/christian.jpg"));
      drama.add(new Actor("Morgan Freeman", "(445) 776-9076", "https://api.androidhive.info/json/images/morgan.jpg"));
      drama.add(new Actor("Scarlett Johanssonn", "(545) 454-2567", "https://api.androidhive.info/json/images/scarlett.jpg"));


      ArrayList<Actor> accion = new ArrayList<>();
      accion.add(new Actor("Tom Cruise",  "(541) 453-2311", "https://api.androidhive.info/json/images/tom_cruise.jpg"));
      accion.add(new Actor("Robert De Niro",  "(767) 544-8867", "https://api.androidhive.info/json/images/robert_de.jpg"));
      accion.add(new Actor("Russell Crowe",  "(234) 234-3321", "https://api.androidhive.info/json/images/russell.jpg"));
      accion.add(new Actor("Keanu Reeves",  "(454) 455-5445", "https://api.androidhive.info/json/images/keanu.jpg"));
      accion.add(new Actor("Robert Downey Jr.",  "(444) 444-4444", "https://api.androidhive.info/json/images/robert.jpg"));



      ArrayList<Actor> comedia = new ArrayList<>();
      comedia.add(new Actor("Will Smith",  "(541) 879-3453", "https://api.androidhive.info/json/images/will.jpg"));
      comedia.add(new Actor("Hugh Jackman",  "(544) 454-4544", "https://api.androidhive.info/json/images/hugh.jpg"));
      comedia.add(new Actor("Tom Hanks",  "(541) 454-4544", "https://api.androidhive.info/json/images/tom.jpg"));

      ArrayList<Category> mCategories = new ArrayList<>();
      mCategories.add(new Category("Drama",drama));
      mCategories.add(new Category("Accion",accion));
      mCategories.add(new Category("Comedia",comedia));

      return mCategories;
   }



}
