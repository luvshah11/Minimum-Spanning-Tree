# Simple helper script to output graphviz DOT definitions
lines = []
with open("cta.txt") as f:
    lines = f.readlines()
count = 0
for line in lines:
    if not count < 2:
        l = line.split(" ")
        if l[0].startswith("//"):
            None
        else:
            print(f"{l[0]} -> {l[1]} [dir=both,label=\"{l[2].strip()}\"]")
    count += 1

