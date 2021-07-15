package practice02;

public class CreateSQL extends DatabaseOperation{

	//フィールド
	private String sql;
	StringBuilder sb = new StringBuilder(100);

	//メソッド
	public String selectFrend(){
		sb.append("SELECT ");
		sb.append("id, ");
		sb.append("name, ");
		sb.append("mail ");
		sb.append("FROM ");
		sb.append("friend;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}
	public String insertFrend() {
		sb.append("INSERT INTO ");
        sb.append("friend(");
        sb.append("name, ");
        sb.append("mail");
        sb.append(") value(");
        sb.append("?, ");
        sb.append("?");
        sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectActor() {
		sb.append("SELECT ");
		sb.append("id, ");
		sb.append("name ");
		sb.append("FROM ");
		sb.append("actor;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}
	public String insertActor() {
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append("actor(");
		sb.append("name");
		sb.append(")VALUE(");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectGenre() {
		sb.append("SELECT ");
		sb.append("id, ");
		sb.append("name ");
		sb.append("FROM ");
		sb.append("genre;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}
	public String insertGenre() {
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append("genre(");
		sb.append("name ");
		sb.append(")VALUE(");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectDvd() {
		sb.append("SELECT ");
		sb.append("id, ");
		sb.append("name ");
		sb.append("FROM ");
		sb.append("dvd;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
    }

	public String insertDvd() {
		sb.append("INSERT INTO ");
		sb.append("dvd(");
		sb.append("name ");
		sb.append(")VALUE(");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectDvdActor() {
		sb.append("SELECT ");
		sb.append("a.dvd_id as id, ");
		sb.append("b.name ");
		sb.append("FROM ");
		sb.append("dvd_actor as a ");
		sb.append("INNER JOIN ");
		sb.append("actor as b ");
		sb.append("ON ");
		sb.append("a.actor_id = b.id");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}
	public String insertDvdActor() {
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append("dvd_actor(");
		sb.append("dvd_id, ");
		sb.append("actor_id");
		sb.append(")VALUE(");
		sb.append("?, ");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectSearchDvdActor() {
		sb.append("SELECT ");
		sb.append("a.dvd_id as id ");
		sb.append("FROM ");
		sb.append("dvd_actor as a ");
		sb.append("INNER JOIN ");
		sb.append("actor as b ");
		sb.append("ON ");
		sb.append("a.actor_id = b.id ");
		sb.append("WHERE ");
		sb.append("a.actor_id ");
		sb.append("= ");
		sb.append("?");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectSearchDvdGenre() {
		sb.append("SELECT ");
		sb.append("a.dvd_id as id ");
		sb.append("FROM ");
		sb.append("dvd_genre as a ");
		sb.append("INNER JOIN ");
		sb.append("genre as b ");
		sb.append("ON ");
		sb.append("a.genre_id = b.id ");
		sb.append("WHERE ");
		sb.append("a.genre_id");
		sb.append("= ");
		sb.append("?");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectDvdGenre() {
		sb.append("SELECT ");
		sb.append("a.dvd_id as id, ");
		sb.append("b.name ");
		sb.append("FROM ");
		sb.append("dvd_genre as a ");
		sb.append("INNER JOIN ");
		sb.append("genre as b ");
		sb.append("ON ");
		sb.append("a.genre_id = b.id");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String insertDvdGenre() {
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append("dvd_genre(");
		sb.append("dvd_id, ");
		sb.append("genre_id");
		sb.append(")VALUE(");
		sb.append("?, ");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String insertRental() {
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append("rental(");
		sb.append("friend_id, ");
		sb.append("rental_date");
		sb.append(")VALUE(");
		sb.append("?, ");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String insertRentalDvd() {
		sb.append("INSERT ");
		sb.append("INTO ");
		sb.append("rental_dvd(");
		sb.append("rental_id, ");
		sb.append("dvd_id, ");
		sb.append("return_flg");
		sb.append(")VALUE(");
		sb.append("?, ");
		sb.append("?, ");
		sb.append("?");
		sb.append(");");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectRental() {
		sb.append("SELECT ");
        sb.append("a.id, ");
        sb.append("b.name, ");
        sb.append("a.rental_date ");
        sb.append("FROM ");
        sb.append("rental as a ");
        sb.append("INNER JOIN ");
        sb.append("friend as b ");
        sb.append("ON ");
        sb.append("a.friend_id = ");
        sb.append("b.id;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectRentalDvd() {
		sb.append("SELECT ");
        sb.append("a.rental_id as id, ");
        sb.append("a.dvd_id, ");
        sb.append("b.name, ");
        sb.append("a.return_flg ");
        sb.append("FROM ");
        sb.append("rental_dvd as a ");
        sb.append("INNER JOIN ");
        sb.append("dvd as b ");
        sb.append("ON ");
        sb.append("a.dvd_id = ");
        sb.append("b.id ");
        sb.append("WHERE ");
        sb.append("a.rental_id = ");
        sb.append("? ");
        sb.append("HAVING a.return_flg =");
        sb.append("1;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectHistoryDvd() {
		sb.append("SELECT ");
		sb.append("a.rental_id as id, ");
		sb.append("a.dvd_id, ");
		sb.append("b.name, ");
		sb.append("a.return_flg ");
		sb.append("FROM ");
		sb.append("rental_dvd as a ");
		sb.append("INNER JOIN ");
		sb.append("dvd as b");
		sb.append("ON ");
		sb.append("a.dvd_id = ");
		sb.append("b.id ");
		sb.append("WHERE ");
		sb.append("a.rental_id = ");
		sb.append("? ");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String updateRentalDvd() {
		sb.append("UPDATE ");
		sb.append("rental_dvd ");
		sb.append("SET ");
		sb.append("return_flg = ");
		sb.append("0 ");
		sb.append("WHERE ");
		sb.append("rental_id = ");
		sb.append("? ");
		sb.append("AND ");
		sb.append("dvd_id = ");
		sb.append("?");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectSearchDvd() {
		sb.append("SELECT ");
		sb.append("id, ");
		sb.append("name ");
		sb.append("FROM ");
		sb.append("dvd ");
		sb.append("WHERE ");
		sb.append("name ");
		sb.append("LIKE ");
		sb.append("?");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectSearchIdDvd(int num) {
		sb.append("SELECT ");
		sb.append("id, ");
		sb.append("name ");
		sb.append("FROM ");
		sb.append("dvd ");
		sb.append("WHERE ");
		sb.append("id ");
		sb.append("IN ");
		sb.append("(");
		for(int i = 1; i < num; i++) {
			sb.append("?, ");
		}
		sb.append("?");
		sb.append(")");
		sb.append(";");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}

	public String selectIdRental() {
		sb.append("SELECT ");
		sb.append("a.id, ");
		sb.append("b.name, ");
		sb.append("a.rental_date ");
		sb.append("FROM ");
		sb.append("rental as a ");
		sb.append("INNER JOIN ");
		sb.append("friend as b ");
		sb.append("ON ");
		sb.append("a.friend_id = ");
		sb.append("b.id ");
		sb.append("HAVING ");
		sb.append("a.id = ");
		sb.append("?;");

		this.sql = sb.toString();
		System.out.println("StringBuilderで作ったSQL文：" + this.sql);
		return this.sql;
	}
}
