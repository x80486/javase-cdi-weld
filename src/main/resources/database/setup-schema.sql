---
--- SPELL_BOOKS TABLE
---
create table spell_books (
  id      uuid         not null,
  name    varchar(150) not null,
  version integer      not null,

  primary key (id)
);

---
--- SPELLS TABLE
---
create table spells (
  id               uuid         not null,
  name             varchar(150) not null,
  version          integer      not null,

  spell_book_id_fk uuid         not null,

  primary key (id),
  constraint spell_spell_book_fk foreign key (spell_book_id_fk) references spell_books (id)
);

commit;
