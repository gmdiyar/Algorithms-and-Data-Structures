                if (words.containsKey(token) && words.get(token) > 1) {
                    Integer freq = words.get(token);
                    System.out.println(freq++);
                    words.replace(token, freq++);
                }