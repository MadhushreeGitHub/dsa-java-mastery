package com.madhushree.week1.day1;


    interface DataType<T> {
        void addition(T a, T b);
        void subtraction(T a, T b);
        void multiplication(T a, T b);
        void division(T a, T b);
    }

    class Generic<T extends Number> implements DataType<T> {
        public void addition(T a, T b)       { System.out.println(a.doubleValue() + b.doubleValue()); }
        public void subtraction(T a, T b)    { System.out.println(a.doubleValue() - b.doubleValue()); }
        public void multiplication(T a, T b) { System.out.println(a.doubleValue() * b.doubleValue()); }
        public void division(T a, T b) {
            if (b.doubleValue() == 0) { System.out.println("Cannot divide by zero"); return; }
            System.out.println(a.doubleValue() / b.doubleValue());
        }
    }

    class StringDataType implements DataType<String> {
        public void addition(String a, String b)       { System.out.println(a + b); }
        public void subtraction(String a, String b)    { System.out.println("Can't perform this operation for Strings"); }
        public void multiplication(String a, String b) { System.out.println("Can't perform this operation for Strings"); }
        public void division(String a, String b)       { System.out.println("Can't perform this operation for Strings"); }
    }

