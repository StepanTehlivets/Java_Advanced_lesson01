package ua.academy.lgs;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class Schedule {
	Set<Seance> seances = new TreeSet<>();

	public Schedule() {

	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}
	static Supplier<Seance> seanceSupplier = () -> new Seance(Cinema.newMovie.get() , new Time());;
	static MySeanceSupplier<Seance> mySeanceSupplier = (movie) -> new Seance(movie , new Time());;

	public void addSeance(Seance s) {

		seances.add(s);
	};

	public void removeSeance() {
		seances.remove(seanceSupplier.get());
	}
	
	public void removeSeanceWithMovie(Movie movie) {
		Iterator<Seance> iterator = seances.iterator();
		while(iterator.hasNext()) {
			Seance next = iterator.next();
			if(next.getMovie().equals(movie)){
				seances.remove(next);
			}
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seances == null) ? 0 : seances.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (seances == null) {
			if (other.seances != null)
				return false;
		} else if (!seances.equals(other.seances))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scheduled seances=" + seances;
	};

}


@FunctionalInterface
interface MySeanceSupplier<Seance>{
	Seance get(Movie m);
	
}
