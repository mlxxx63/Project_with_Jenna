class Video:
	def __init__(self, title, link):
		self.title = title
		self.link = link

def read_video():
	title = input("Enter title: ")
	link = input("Enter link: ")
	video = Video(title, link)
	return video

def print_video(video):
	print("Video title: ", video.title)
	print("Video link: ", video.link)

def read_videos():
	videos = []
	total_video = int(input("Enter how many videos: "))
	for i in range(total_video):
		print("Enter video ", i+1)
		vid = read_video()
		videos.append(vid)
	return videos

def print_videos(videos):
	print("---")
	for i in range(len(videos)):
		print_video(videos[i])

def write_video_txt(video, file):
	file.write(video.title + "\n")
	file.write(video.link + "\n")

def write_to_txt(videos):
	total = len(videos)
	with open("data.txt", "w") as file:
		file.write(str(total) + "\n")
		for i in range(total):
			write_video_txt(videos[i], file)

def read_videos_from_text():
	videos = []
	with open("data.txt", "r") as file:
		total = file.readline()
		for i in range(int(total)):
			title = file.readline()
			link = file.readline()
			video = Video(title, link)
			videos.append(video)

	return videos

def main():
	videos = read_videos()
	write_to_txt(videos)	
	video = read_videos_from_text()
	print_videos(videos)
##Hello!
##How are you?
main()
