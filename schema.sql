create database "myschool-db1"
    with owner postgres;

create type public.course_status as enum ('In Progress', 'Completed', 'Failed');

alter type public.course_status owner to postgres;

create type public.course_type as enum ('Compulsory', 'Departmental Elective', 'University Elective');

alter type public.course_type owner to postgres;

create table public.departments
(
    departmentid   serial
        primary key,
    facultyname    varchar(100) not null,
    departmentname varchar(100) not null,
    unique (facultyname, departmentname)
);

alter table public.departments
    owner to postgres;

create table public.students
(
    studentid        serial
        primary key,
    firstname        varchar(50)               not null,
    lastname         varchar(50)               not null,
    studentnumber    varchar(20)               not null
        unique,
    email            varchar(100)              not null
        unique,
    departmentid     integer
        constraint fk_department_student
            references public.departments
            on delete set null,
    registrationdate date default CURRENT_DATE not null
);

alter table public.students
    owner to postgres;

create table public.courses
(
    courseid     serial
        primary key,
    coursecode   varchar(10)  not null
        unique,
    coursename   varchar(100) not null,
    credits      integer      not null
        constraint courses_credits_check
            check (credits > 0),
    departmentid integer      not null
        constraint fk_department_course
            references public.departments
            on delete cascade,
    coursetype   course_type  not null
);

alter table public.courses
    owner to postgres;

create table public.semesters
(
    semesterid serial
        primary key,
    year       integer     not null,
    term       varchar(20) not null,
    unique (year, term)
);

alter table public.semesters
    owner to postgres;

create table public.studentcourseregistrations
(
    registrationid serial
        primary key,
    studentid      integer       not null
        constraint fk_student
            references public.students
            on delete cascade,
    courseid       integer       not null
        constraint fk_course
            references public.courses
            on delete restrict,
    semesterid     integer       not null
        constraint fk_semester
            references public.semesters
            on delete restrict,
    grade          numeric(3, 2),
    status         course_status not null,
    unique (studentid, courseid, semesterid)
);

alter table public.studentcourseregistrations
    owner to postgres;

