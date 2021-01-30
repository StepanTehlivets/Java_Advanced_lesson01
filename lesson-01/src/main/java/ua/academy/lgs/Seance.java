package ua.academy.lgs;

public class Seance  implements Comparable<Seance>{
	Movie movie;
	Time startTime;
	Time endTime;

	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.setEndTime();
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime() {
		int filmHours = movie.getTime().getHours();
		int filmMinutes = movie.getTime().getMin();
		int startTimeHours = startTime.getHours();
		int startTimeMinutes = startTime.getMin();

		int endTimeHours = filmHours + startTimeHours;
		int endTimeMinutes = filmMinutes + startTimeMinutes;

		if (endTimeMinutes > 60) {
			endTimeHours++;
			endTimeMinutes = endTimeMinutes - 60;
		}
		Time endTime = new Time(endTimeHours, endTimeMinutes);
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Movie " +"«"+ movie + "»"+" will start: " + startTime + " and will end: " + endTime + "]";
	}

	@Override
	public int compareTo(Seance o) {
	
		return this.startTime.compareTo(o.getStartTime());
	}

	
}
