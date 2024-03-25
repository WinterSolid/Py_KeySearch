import os

def search_keywords_in_files(directory, keywords):
    found = []
    for filename in os.listdir(directory):
        filepath = os.path.join(directory, filename)
        if os.path.isfile(filepath):
            with open(filepath, 'r') as file:
                for line_num, line in enumerate(file, start=1):
                    if any(keyword in line for keyword in keywords):
                        found.append((filename, line_num, line.rstrip()))
    return found

if __name__ == "__main__":
    directory = "/path/to/your/files"
    keywords = {"keyword1", "keyword2", "keyword3"}
    results = search_keywords_in_files(directory, keywords)
    for result in results:
        print(result)
