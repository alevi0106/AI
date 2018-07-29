board=[2]*10
board_copy=[" "]*10
trick=[0,8,3,4,1,5,9,6,7,2]
play1=[0]*5
play2=[0]*5

#To draw a board
def draw():
	for i in range(1,10):
		if board[i]==3:
			board_copy[i]="X"
		if board[i]==5:
			board_copy[i]="O"
	#print(board_copy)
	print(' {} | {} | {}'.format(board_copy[1],board_copy[2],board_copy[3]))
	print(' {} | {} | {}'.format(board_copy[4],board_copy[5],board_copy[6]))
	print(' {} | {} | {}'.format(board_copy[7],board_copy[8],board_copy[9]))
	print('')	
	
def Go(n,turn,k,l):
	if turn%2==0:
		board[n]=5
		play2[l]=trick[n]
	else:
		board[n]=3 
		play1[k]=trick[n]

def fb(a,b,c):
	if board[a]==2:
		return a
	elif board[b]==2:
		return b
	elif board[c]==2:
		return c
	return a

def Make():
	if board[5]==2:
		return 5
	elif board[2]==2:
		return 2
	elif board[4]==2:
		return 4
	elif board[6]==2:
		return 6
	elif board[8]==2:
		return 8
	 
def Posswin(pos):
	if pos=="X":
		for i in range(0,5):
			if play1[i]!=0:
				for j in range(i+1,5):
					if 0<(15-(play1[i]+play1[j]))<10 and play1[j]!=0:
						p=15-(play1[i]+play1[j])
						for k in range(1,10):
							if trick[k]==p and board[k]==2:
								return k

	if pos=="O":
		for i in range(0,5):
			if play2[i]!=0:
				for j in range(i+1,5):
					if 0<(15-(play2[i]+play2[j]))<10 and play2[j]!=0:
						p=15-(play2[i]+play2[j])
						for k in range(1,10):
							if trick[k]==p and board[k]==2:		
								return k
	return 0

def iswin():
	for i in range(0,2):
		for j in range(i+1,3):
			for k in range(j+1,4):
				if play1[i]+play1[j]+play1[k]==15 and play1[k]!=0:
					print(play1[i],play1[j],play1[k])
					print("Winner is X")
					return 1
				elif play2[i]+play2[j]+play2[k]==15 and play2[k]!=0:
					print(play2[i],play2[j],play2[k])
					print("Winner is O")
					return 1
	return 0


val=int(input("Choose 3 for 'X' or 5 for 'O':\n"))
if val==3:
	tempvar1=1
	tempvar2=0
elif val==5:
	tempvar1=0
	tempvar2=1
k=l=0
for turn in range(1,10):
	if turn%2==tempvar1:
		cross=int(input("Where to mark?\n"))
		board[cross]=val
		if val==3:
			play1[k]=trick[cross]
			k+=1
		else:
			play2[l]=trick[cross]
			l+=1
		draw()
		if iswin()==1:
			break
		elif turn==9:
			print("Match is draw")
	elif turn%2==tempvar2:
		print("AI turn")
		if turn==1:
			Go(1,turn,k,l)
			draw()
			if iswin()==1:
				break
		if turn==2:
			if board[5]==2:
				Go(5,turn,k,l)
			else:Go(1,turn,k,l)
			draw()			
			if iswin()==1:
				break
		if turn==3:
			if board[9]==2:
				Go(9,turn,k,l)
			else:Go(3,turn,k,l)
			draw()			
			if iswin()==1:
				break
		if turn==4:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn,k,l)
			else:Go(Make(),turn,k,l)
			draw()			
			if iswin()==1:
				break
		if turn==5:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn,k,l)
			elif Posswin("O")!=0:
				Go(Posswin("O"),turn,k,l)
			elif board[7]==2:
				Go(7,turn,k,l)
			else:Go(3,turn,k,l)
			draw()
			if iswin()==1:
				break
		if turn==6:
			if Posswin("O")!=0:
				Go(Posswin("O"),turn,k,l)
			elif Posswin("X")!=0:
				Go(Posswin("X"),turn,k,l)
			else:Go(Make(),turn,k,l)
			draw()
			if iswin()==1:
				break
		if turn==7:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn,k,l)
			elif Posswin("O")!=0:
				Go(Posswin("O"),turn,k,l)
			else:Go(fb(fb(1,2,3),fb(4,5,6),fb(7,8,9)),turn,k,l)
			draw()
			if iswin()==1:
				break
		if turn==8:
			if Posswin("O")!=0:
				Go(Posswin("O"),turn,k,l)
			elif Posswin("X")!=0:
				Go(Posswin("X"),turn,k,l)
			else:Go(fb(fb(1,2,3),fb(4,5,6),fb(7,8,9)),turn,k,l)
			draw()
			if iswin()==1:
				break
		if turn==9:
			if Posswin("X")!=0:
				Go(Posswin("X"),turn,k,l)
			elif Posswin("O")!=0:
				Go(Posswin("O"),turn,k,l)
			else:Go(fb(fb(1,2,3),fb(4,5,6),fb(7,8,9)),turn,k,l)
			draw()
			if iswin()==1:
				break
			print("Match is draw")
		if val==3:
			l+=1
		else:k+=1
	





