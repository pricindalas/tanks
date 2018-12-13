package ktu.tanks.visitor;

public interface Visitable {
    int accept(Visitor v);
}
